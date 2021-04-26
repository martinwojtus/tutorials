import { Component, Input, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { Subject } from 'rxjs';
import { Employee } from '../../model/employee.model';
import { EmployeesService } from '../../services/employees.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EmployeeFormComponent } from '../employee-form/employee-form.component';
import { Position2LabelMapping } from 'src/app/model/position.model';
import { DataTableDirective } from 'angular-datatables';
import { EmployeeDeleteComponent } from '../employee-delete/employee-delete.component';

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styles: []
})
export class EmployeesComponent implements OnInit, OnDestroy {

  public Position2LabelMapping = Position2LabelMapping;

  @ViewChild(DataTableDirective, { static: false }) dtElement: DataTableDirective;

  dtTrigger: Subject<any> = new Subject<any>();
  dtOptions: any = {};
  employees: Employee[] = [];
  checkedEmployeeIds: string[] = [];
  gridCheckAll: boolean = false;
  disableEdit: boolean = true;
  disableRemove: boolean = true;

  constructor(private employeeService: EmployeesService, private modalService: NgbModal) {
  }

  ngOnInit(): void {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true,
      lengthChange: false,
    };
    this.getEmployees(true);
  }

  getEmployees(trigger: boolean): void {
    this.employeeService.list()
      .subscribe(data => {
        this.employees = data;

        if (trigger) {
          this.dtTrigger.next();
        }
      });
  }

  openForAdd(): void {
    const modalRef = this.modalService.open(EmployeeFormComponent);
    modalRef.componentInstance.employee = new Employee();
    modalRef.result.then((data) => {
      this.refreshEmployees();
    }, (reason) => {
      // on dismiss
    });
  }

  openForEdit(): void {
    const modalRef = this.modalService.open(EmployeeFormComponent);
    modalRef.componentInstance.employee = this.employees.find(e => e.id == this.checkedEmployeeIds[0]);
    modalRef.result.then((data) => {
      this.refreshEmployees();
    }, (reason) => {
      // on dismiss
    });
  }

  openDeleteConfirmation(): void {
    const modalRef = this.modalService.open(EmployeeDeleteComponent);
    modalRef.componentInstance.employees = this.employees.filter(e => this.checkedEmployeeIds.includes(e.id));

    modalRef.result.then((data) => {
      this.refreshEmployees();
    }, (reason) => {
      // on dismiss
    });
  }

  refreshEmployees(): void {
    this.getEmployees(false);
    this.checkedEmployeeIds = [];
    this.checkDisabled();
    this.rerender();
  }

  rowCheckBoxChecked(e, employeeId): void {
    if (e.currentTarget.checked) {
      this.checkedEmployeeIds.push(employeeId);
    } else {
      this.checkedEmployeeIds.splice(this.checkedEmployeeIds.indexOf(employeeId), 1);
    }

    this.checkDisabled();
  }

  gridAllRowsCheckBoxChecked(e): void {
    this.checkedEmployeeIds = [];

    if (this.gridCheckAll) {
      this.gridCheckAll = false;
      this.employees.forEach(e => e.checked = false);

    } else {
      this.gridCheckAll = true;
      this.employees.forEach(e => {
        e.checked = true;
        this.checkedEmployeeIds.push(e.id);
      });
    }

    this.checkDisabled();
  }

  checkDisabled(): void {
    this.disableEdit = this.checkedEmployeeIds.length != 1;
    this.disableRemove = this.checkedEmployeeIds.length < 1;
  }

  rerender(): void {
    this.dtElement.dtInstance.then((dtInstance: DataTables.Api) => {
      // Destroy the table first
      dtInstance.destroy();
      // Call the dtTrigger to rerender again
      this.dtTrigger.next();
    });
  }

  ngOnDestroy(): void {
    this.dtTrigger.unsubscribe();
  }
}
