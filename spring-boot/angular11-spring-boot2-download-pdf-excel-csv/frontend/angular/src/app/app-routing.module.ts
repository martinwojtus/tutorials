import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FilesComponent } from './components/files/files.component';

const routes: Routes = [
  { path: '', redirectTo: 'files', pathMatch: 'full' },
  { path: 'files', component: FilesComponent },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {
}
