import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SavedComponent } from './saved-data/saved-data.component';

const routes: Routes = [
 // { path: '', redirectTo: '', pathMatch: 'full' },
  //{ path: 'employees', component: SavedComponent },
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
