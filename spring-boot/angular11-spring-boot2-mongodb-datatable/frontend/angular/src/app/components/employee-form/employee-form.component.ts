import { Component, Input, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Employee } from '../../model/employee.model';
import { Position, Position2LabelMapping } from '../../model/position.model';
import { EmployeesService } from '../../services/employees.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styles: []
})
export class EmployeeFormComponent implements OnInit {

  @Input() employee: Employee;
  form: FormGroup;

  public Position2LabelMapping = Position2LabelMapping;
  public positions = Object.values(Position);

  constructor(private activeModal: NgbActiveModal,
              private employeeService: EmployeesService,
              private formBuilder: FormBuilder) {

    this.createForm();
  }

  private createForm() {
    this.form = this.formBuilder.group({
      firstName: [ '', Validators.required ],
      lastName: [ '', Validators.required ],
      position: [ '', Validators.required ],
      startDate: [ '', Validators.required ],
      salary: [ '', [ Validators.required, Validators.pattern('[0-9]*') ] ],
    });
  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      control.markAsTouched({ onlySelf: true });
    });
  }

  save(): void {
    if (this.form.dirty && this.form.valid) {
      let startDate: any = this.form.value.startDate;
      let employee = this.form.value as Employee;
      employee.startDate = new Date(startDate.year, startDate.month, startDate.day);

      if (this.employee.id) {
        employee.id = this.employee.id;

        this.employeeService.update(employee).subscribe(value => {
          this.activeModal.close('Close after update');
        });
      } else {
        this.employeeService.save(employee).subscribe(value => {
          this.activeModal.close('Close after save');
        });
      }

    } else {
      this.validateAllFormFields(this.form);
    }
  }

  close(): void {
    this.activeModal.dismiss('Close click');
  }

  ngOnInit(): void {
    if (this.employee && this.employee.id) {

      const startDate = this.employee.startDate ?
        {
          day: this.employee.startDate.getDate(),
          month: this.employee.startDate.getMonth(),
          year: this.employee.startDate.getFullYear()
        } : null;

      this.form.setValue({
        firstName: this.employee.firstName,
        lastName: this.employee.lastName,
        position: this.employee.position,
        startDate: startDate,
        salary: this.employee.salary
      });
    }
  }
}
