import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MentionOnSearchTypes } from 'ng-zorro-antd/mention';
import { UserHttpService } from './user-http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title = 'mention';
  validateForm!: FormGroup;
  inputValue?: string;
  loading = false;
  topUsers: string[] = [];

  constructor(private fb: FormBuilder,
              private userHttpService: UserHttpService) {
  }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      mention: [null, [Validators.required]]
    });

    this.getTop();
  }

  private getTop() {
    this.userHttpService.getTopUsers().subscribe(topUsers => {
      this.topUsers = topUsers;
    }, () => alert('An error occurred while retrieving top usernames'));
  }

  submitForm(): void {
    Object.keys(this.validateForm.controls).forEach(field => {
      const control = this.validateForm.get(field);
      control?.markAsTouched({onlySelf: true});
    });
    if (this.validateForm.dirty && this.validateForm.valid) {
      let mention: any = this.validateForm.value.mention;
      let list = mention ? mention.split('@').filter((u: string) => u != '').map((u: string) => u.trim()) : [];
      this.userHttpService.save(list).subscribe(found => {
        this.getTop();
      }, () => {
        alert('An error occurred!');
      });
    }
  }

  resetForm(): void {
    this.validateForm?.reset();
  }

  suggestions: string[] = [];

  onSearchChange({value}: MentionOnSearchTypes): void {
    this.loading = true;
    this.fetchSuggestions(value, suggestions => {
      this.suggestions = suggestions;
      this.loading = false;
    });
  }

  fetchSuggestions(value: string, callback: (suggestions: string[]) => void): void {
    this.userHttpService.list(value).subscribe(found => {
      callback(found);
    });
  }
}
