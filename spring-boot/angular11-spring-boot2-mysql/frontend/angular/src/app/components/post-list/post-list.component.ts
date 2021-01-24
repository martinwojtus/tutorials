import { Component, OnInit } from '@angular/core';
import { Post } from '../../model/post.model';
import { PostService } from '../../services/post.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.components.html'
})
export class PostListComponent implements OnInit {

  posts?: Post[];
  selected?: Post;
  currentIndex: number = -1;
  title: string = '';
  message: string = '';

  constructor(private postService: PostService, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.queryParams
      .subscribe(params => {
          if (params.title) {
            this.getPostsByTitle(params.title);
          } else {
            this.getPosts();
          }
        }
      );
  }

  getPostsByTitle(title: string): void {
    this.postService.findByTitle(title)
      .subscribe(
        data => {
          this.posts = data;
        },
        error => {
          console.error(error);
        });
  }

  getPosts(): void {
    this.postService.list()
      .subscribe(
        data => {
          this.posts = data;
        },
        error => {
          console.error(error);
        });
  }

  refreshList(): void {
    this.getPosts();
    this.selected = undefined;
    this.currentIndex = -1;
  }

  setSelected(post: Post, index: number): void {
    if (this.selected && this.selected.id == post.id) {
      this.selected = undefined;
      this.currentIndex = -1;
    } else {
      this.selected = post;
      this.currentIndex = index;
    }
  }

  searchTitle(): void {
    this.selected = undefined;
    this.currentIndex = -1;

    this.postService.findByTitle(this.title)
      .subscribe(
        data => {
          this.posts = data;
        },
        error => {
          console.error(error);
        });
  }

  deletePost(): void {
    if (!this.selected) {
      return;
    }

    this.postService.delete(this.selected.id)
      .subscribe(
        response => {
          this.refreshList();
        },
        error => {
          console.error(error);
        });
  }

  updatePublished(status: boolean): void {
    if (!this.selected) {
      return;
    }

    const data = {
      id: this.selected.id,
      published: status
    };

    this.message = '';

    this.postService.publishUnpublish(this.selected.id, data)
      .subscribe(
        response => {
          if (this.selected) {
            this.selected.published = status;
          }
        },
        error => {
          console.error(error);
        });
  }
}
