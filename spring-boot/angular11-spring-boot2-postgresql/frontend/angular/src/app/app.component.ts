import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: [ './app.component.css' ]
})
export class AppComponent {
  title = 'Angular 11 with Spring Boot 2.x';

  searchPosts($event: any) {
    if ($event.keyCode === 13) {
      $event.preventDefault();
      $event.target.parentElement.submit();
    }
  }
}
