import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TableComponent } from './table.component';
import { TableRoutingModule } from './table-routing.module';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzDropDownModule } from 'ng-zorro-antd/dropdown';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NzPopconfirmModule } from 'ng-zorro-antd/popconfirm';
import { NzSpaceModule } from 'ng-zorro-antd/space';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { PersonFormModalComponent } from '../../components/person-form-modal/person-form-modal.component';
import { NzFormModule } from 'ng-zorro-antd/form';


@NgModule({
  declarations: [
    TableComponent,
    PersonFormModalComponent
  ],
  imports: [
    CommonModule,
    TableRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NzTableModule,
    NzIconModule,
    NzDropDownModule,
    NzInputModule,
    NzButtonModule,
    NzPopconfirmModule,
    NzSpaceModule,
    NzModalModule,
    NzFormModule
  ]
})
export class TableModule {
}
