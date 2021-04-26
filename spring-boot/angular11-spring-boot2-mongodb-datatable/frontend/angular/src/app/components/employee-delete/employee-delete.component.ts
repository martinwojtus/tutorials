import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { EmployeesService } from '../../services/employees.service';
import { Employee } from '../../model/employee.model';
import { Position2LabelMapping } from 'src/app/model/position.model';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styles: []
})
export class EmployeeDeleteComponent implements OnInit {

  @Input() employees: Employee[] = [];
  public Position2LabelMapping = Position2LabelMapping;

  constructor(private activeModal: NgbActiveModal,
              private employeeService: EmployeesService) {
  }

  ngOnInit(): void {
  }

  close(): void {
    this.activeModal.dismiss('Close click');
  }

  delete(): void {
    this.employeeService.deleteAll(this.employees.map(e => e.id)).subscribe(value => {
      this.activeModal.close('Close after remove');
    });
  }
}
