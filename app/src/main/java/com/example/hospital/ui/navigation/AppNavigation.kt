package com.example.hospital.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.hospital.MainActivity
import com.example.hospital.presentation.CompRegViewModel
import com.example.hospital.presentation.EhsViewModel
import com.example.hospital.presentation.MoreInfoViewModelFirst
import com.example.hospital.presentation.MoreInfoViewModelFourth
import com.example.hospital.presentation.MoreInfoViewModelSecond
import com.example.hospital.presentation.MoreInfoViewModelThird
import com.example.hospital.presentation.OtViewModel
import com.example.hospital.presentation.PatientEntryViewModel
import com.example.hospital.presentation.RegistrationViewModel
import com.example.hospital.ui.components.CustomAlert
import com.example.hospital.ui.screens.CompanyRegistrationScreen
import com.example.hospital.ui.screens.DashBoardDrawer
import com.example.hospital.ui.screens.EhsRegistrationScreen
import com.example.hospital.ui.screens.LoginScreen
import com.example.hospital.ui.screens.MoreInfoScreen1
import com.example.hospital.ui.screens.MoreInfoScreen2
import com.example.hospital.ui.screens.MoreInfoScreen3
import com.example.hospital.ui.screens.MoreInfoScreen4
import com.example.hospital.ui.screens.OTScreen
import com.example.hospital.ui.screens.PatientEntryScreen
import com.example.hospital.ui.screens.RegistrationScreen
import kotlin.system.exitProcess

@Composable
fun AppNavigation(navHost: NavHostController) {
    NavHost(navController = navHost, startDestination = Routes.LOGIN.path) {
        composable(route = Routes.LOGIN.path) {
            LoginScreen(onNavigation = navHost::customNavigate)
        }
        composable(route = Routes.REGISTRATION.path) {
            val viewModel: RegistrationViewModel = viewModel()
            RegistrationScreen(navHost, viewModel)
        }



        navigation(startDestination = Routes.DASHBOARD.path, route = Routes.AUTHORISED.path) {
            composable(route = Routes.DASHBOARD.path) {
                val activity = LocalContext.current as MainActivity
                var showExitDialog by remember { mutableStateOf(false) }

                val dismissAction = {
                    showExitDialog = false
                }

                CustomAlert(dismiss = dismissAction, yes = {
                    activity.finish()
                    exitProcess(0)
                }, no = dismissAction, dismissOnBack = false, dismissOutsideClick = false)

                DashBoardDrawer(navigate = navHost::customNavigate)
            }
            composable(route = Routes.EHS.path) {
                val viewModel: EhsViewModel = viewModel()
                EhsRegistrationScreen(navHost, viewModel)
            }
            composable(route = Routes.PATIENT_ENTRY.path) {
                val viewModel: PatientEntryViewModel = viewModel()
                PatientEntryScreen(navHost, viewModel)
            }
            composable(route = Routes.GENERAL_OT.path) {
                val viewModel: OtViewModel = viewModel()
                OTScreen(navHost, viewModel)
            }
            composable(route = Routes.COMPANY_REGISTRATION.path) {
                val viewModel: CompRegViewModel = viewModel()
                CompanyRegistrationScreen(navHost, viewModel)
            }
            composable(route = Routes.MORE_INFO1.path) {
                val viewModel: MoreInfoViewModelFirst = viewModel()
                MoreInfoScreen1(navHost, viewModel)
            }
            composable(route = Routes.MORE_INFO1.path) {
                val viewModel: MoreInfoViewModelSecond = viewModel()
                MoreInfoScreen2(navHost, viewModel)
            }
            composable(route = Routes.MORE_INFO1.path) {
                val viewModel: MoreInfoViewModelThird = viewModel()
                MoreInfoScreen3(navHost, viewModel)
            }
            composable(route = Routes.MORE_INFO1.path) {
                val viewModel: MoreInfoViewModelFourth = viewModel()
                MoreInfoScreen4(navHost, viewModel)
            }
        }
    }
}


enum class Routes(val path: String) {
    LOGIN("login"),
    REGISTRATION("registrationForm"),
    AUTHORISED("authorised"),
    DASHBOARD("dashboard"),
    EHS("ehsForm"),
    PATIENT_ENTRY("patientEntry"),
    GENERAL_OT("operationTheatre"),
    COMPANY_REGISTRATION("companyRegistration"),
    MORE_INFO1("moreInfo")

}

fun NavHostController.customNavigate(param: String, popup: Boolean = false) {
    if (popup) {
        this.popBackStack()
    }
    this.navigate(param)
}