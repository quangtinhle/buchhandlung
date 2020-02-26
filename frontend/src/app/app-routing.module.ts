import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AppComponent} from './app.component';
import {BuchComponent} from './pages/buch/buch.component';
import {HomeComponent} from './pages/home/home.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'buch', component: BuchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
