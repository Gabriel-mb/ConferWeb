import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SearchService } from '../../services/search.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-card',
  imports: [FormsModule, CommonModule],
  templateUrl: './card.html',
  styleUrl: './card.scss'
})
export class Card implements OnInit {
  borrowedData: any;
  employeeId!: number;

  constructor(
    private route: ActivatedRoute,
    private searchService: SearchService
  ) {}

  ngOnInit() {
    this.employeeId = parseInt(this.route.snapshot.paramMap.get('id')!);
    this.searchService.getBorrowedItems(this.employeeId).subscribe({
      next: (response) => {
        console.log('Dados recebidos:', response);
        console.log('Borrowed Items:', response.borrowedItems);
        console.log('Employee:', response.employee);

        this.borrowedData = response;
      },
      error: (error) => {
        console.error('Erro ao buscar dados:', error);
      }
    });
  }


}
