import { PageInfo } from './page.info';
import { PersonFilter } from './person.filter';

export interface PersonPageRequest {
  pageInfo: PageInfo;
  filter: PersonFilter;
}
