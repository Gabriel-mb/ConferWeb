import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { SearchService } from '../../services/search.service';

@Component({
  selector: 'app-home',
  imports: [CommonModule, FormsModule, MatIconModule, MatButtonModule],
  templateUrl: './home.html',
  styleUrl: './home.scss'
})
export class Home {
  id: string = '';
  
  constructor(private router: Router, private searchService: SearchService) {
  }

  onSearch(frm: NgForm) {
  if (frm.valid) {
    this.router.navigate([`/card/${this.id}`]);
    }
  }
}
