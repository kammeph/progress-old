import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { MatInputModule } from '@angular/material/input'
import { MatOptionModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button'
import { MatIconModule } from '@angular/material/icon'
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTableModule } from '@angular/material/table';
import { MatDividerModule } from '@angular/material/divider';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { VolumecalculatorComponent } from './components/volumecalculator/volumecalculator.component';
import { StrengthvalueComponent } from './components/strengthvalue/strengthvalue.component';
import { StrengthvaluesComponent } from './components/strengthValues/strengthvalues.component';

import { environment } from 'src/environments/environment';
import { TextboxComponent } from './components/textbox/textbox.component';
import { PasswordboxComponent } from './components/passwordbox/passwordbox.component';
import { ComboboxComponent } from './components/combobox/combobox.component';
import { ExercisesComponent } from './components/exercises/exercises.component';
import { ExerciseComponent } from './components/exercise/exercise.component';
import { ExercisegroupsComponent } from './components/exercisegroups/exercisegroups.component';
import { LoadfactorComponent } from './components/loadfactor/loadfactor.component';
import { TestcomboboxComponent } from './components/testcombobox/testcombobox.component';

const appRoutes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'strengthvalues', component: StrengthvaluesComponent },
  { path: 'volumecalculator', component: VolumecalculatorComponent },
  { path: 'exercises', component: ExercisegroupsComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    LoginComponent,
    SignupComponent,
    VolumecalculatorComponent,
    StrengthvalueComponent,
    StrengthvaluesComponent,
    TextboxComponent,
    PasswordboxComponent,
    ComboboxComponent,
    ExercisesComponent,
    ExerciseComponent,
    ExercisegroupsComponent,
    LoadfactorComponent,
    TestcomboboxComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MatInputModule,
    MatOptionModule,
    MatButtonModule,
    MatIconModule,
    MatFormFieldModule,
    MatSelectModule,
    MatExpansionModule,
    MatSidenavModule,
    MatToolbarModule,
    MatTableModule,
    MatDividerModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [
    { provide: 'API_URL', useValue: environment.apiUrl }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
