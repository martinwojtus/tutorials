import { Component, OnInit } from '@angular/core';
import { Person } from '../../model/person';
import { NzTableQueryParams } from 'ng-zorro-antd/table';
import { PersonPageRequest } from '../../model/person.page.request';
import { PersonFilter } from '../../model/person.filter';
import { PageInfo } from '../../model/page.info';
import { SortOrder } from '../../model/sort.order';
import { PersonHttpService } from '../../service/person.http.service';
import { NzModalService } from 'ng-zorro-antd/modal';
import { PersonFormModalComponent } from '../../components/person-form-modal/person-form-modal.component';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent implements OnInit {

  persons: Person[] = [];

  loading = true;
  pageSize = 10;
  pageIndex = 1;
  total = 1;

  visibleFn = false;
  visibleLn = false;

  pageRequest: PersonPageRequest = {
    pageInfo: {
      pageSize: this.pageSize,
      pageNumber: this.pageIndex,
      sort: null
    } as PageInfo,
    filter: {
      firstName: '',
      lastName: ''
    } as PersonFilter
  };

  constructor(private personService: PersonHttpService,
              private modal: NzModalService) {
  }

  ngOnInit(): void {
  }

  onQueryParamsChange(params: NzTableQueryParams): void {
    const {pageSize, pageIndex, sort, filter} = params;
    const currentSort = sort.find(item => item.value !== null);
    const sortField = (currentSort && currentSort.key) || null;
    const sortOrder = (currentSort && currentSort.value) || null;

    this.pageRequest.pageInfo = {
      pageSize: pageSize,
      pageNumber: pageIndex,
      sort: (sortField && sortOrder) ? [
        {
          column: sortField,
          order: sortOrder === 'ascend' ? SortOrder.ASC : SortOrder.DESC
        }
      ] : null
    };

    this.search();
  }

  resetFirstName(): void {
    this.pageRequest.filter.firstName = '';
    this.search();
  }

  resetLastName(): void {
    this.pageRequest.filter.lastName = '';
    this.search();
  }

  search(): void {
    this.visibleFn = false;
    this.visibleLn = false;

    this.loading = true;

    this.personService.personPage(this.pageRequest).subscribe(result => {
      this.persons = result.rows;
      this.total = result.totalElements;
      this.loading = false;
    }, () => this.loading = false);
  }

  addPerson(): void {
    this.modal.create({
      nzContent: PersonFormModalComponent,
      nzWidth: 900,
      nzCentered: true,
      nzComponentParams: {
        person: {} as Person
      } as Partial<PersonFormModalComponent>
    }).afterClose.subscribe(data => {
      if (!!data) {
        this.search();
      }
    });
  }

  removePerson(id: string): void {
    this.personService.delete(id).subscribe(result => {
      this.search();
    })
  }

  editPerson(id: string): void {
    this.personService.find(id).subscribe(result => {
      this.modal.create({
        nzContent: PersonFormModalComponent,
        nzWidth: 900,
        nzCentered: true,
        nzComponentParams: {
          person: result
        } as Partial<PersonFormModalComponent>
      }).afterClose.subscribe(data => {
        if (!!data) {
          this.search();
        }
      });
    });
  }
}
