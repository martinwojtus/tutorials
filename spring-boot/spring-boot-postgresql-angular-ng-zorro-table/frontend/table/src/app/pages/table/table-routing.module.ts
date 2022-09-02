import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { TableComponent } from './table.component';


const routes: Routes = [
  {path: '', component: TableComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TableRoutingModule {

}
