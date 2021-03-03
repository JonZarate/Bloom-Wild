package io.github.jonzarate.bloomwild.viewmodel.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import io.github.jonzarate.bloomwild.TestCoroutineRule
import io.github.jonzarate.bloomwild.controller.ImageUrlProvider
import io.github.jonzarate.bloomwild.controller.PriceFormatter
import io.github.jonzarate.bloomwild.model.data.ProductInfo
import io.github.jonzarate.bloomwild.model.data.ProductsResponse
import io.github.jonzarate.bloomwild.model.net.FakeBloomWildApi
import io.github.jonzarate.bloomwild.model.repo.AppRepositoryImpl
import io.github.jonzarate.bloomwild.model.repo.ProductRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi

import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutionRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val helper = MainViewModelTestHelper()

    /*
        Instead of testing single functions, I rather have integration tests.

        I won't check what classes or functions were called in this flow, I will just feed an input
        and verify the output.

        This tests the behaviour of the class, instead of the implementation details. Hence,
        these tests are easier to maintain and won't need to be changed (except for injecting the
        required dependencies).

        This tests the whole flow from ViewModel to Repository to Controller.

        Unit tests for ImageUrlProvider and PriceFormatter and very susceptible to an
        implementation change.

     */

    @Test
    fun loadsAndSanitisesDataOnLaunchForPhones() = testCoroutineRule.runBlockingTest {
        val apiResponse = ProductsResponse(arrayOf(
            ProductInfo(helper.testData0.rawApiResponse),
            ProductInfo(helper.testData1.rawApiResponse),
            ProductInfo(helper.testData2.rawApiResponse))
        )

        val expectedProducts = listOf(
            helper.testData0.sanitisedForPhone,
            helper.testData1.sanitisedForPhone,
            helper.testData2.sanitisedForPhone,
        )

        val api = FakeBloomWildApi(apiResponse)
        val repo = ProductRepositoryImpl(false, api, ImageUrlProvider(), PriceFormatter())
        val app = AppRepositoryImpl(false)
        val viewModel = MainViewModel(repo, app)

        assertThat(viewModel.products.value).containsExactlyElementsIn(expectedProducts)
    }

    @Test
    fun loadsAndSanitisesDataOnLaunchForTablets() = testCoroutineRule.runBlockingTest {
        val apiResponse = ProductsResponse(arrayOf(
            ProductInfo(helper.testData0.rawApiResponse),
            ProductInfo(helper.testData1.rawApiResponse),
            ProductInfo(helper.testData2.rawApiResponse))
        )

        val expectedProducts = listOf(
            helper.testData0.sanitisedForTablet,
            helper.testData1.sanitisedForTablet,
            helper.testData2.sanitisedForTablet,
        )

        val api = FakeBloomWildApi(apiResponse)
        val repo = ProductRepositoryImpl(true, api, ImageUrlProvider(), PriceFormatter())
        val app = AppRepositoryImpl(true)
        val viewModel = MainViewModel(repo, app)

        assertThat(viewModel.products.value).containsExactlyElementsIn(expectedProducts)
    }

}