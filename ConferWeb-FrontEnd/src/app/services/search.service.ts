import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface BorrowedItem {
  equipmentName: string;
  idEquipment: number;
  employeeId: number;
  supplierName: string;
  supplierId: number;
  date: string;
}

export interface Employee {
  employeeId: number;
  name: string;
}

export interface BorrowedItemsResponse {
  borrowedItems: BorrowedItem[];
  employee: Employee;
}


@Injectable({
  providedIn: 'root'
})
export class SearchService {
 
  http = inject(HttpClient);

  private apiUrl = 'http://localhost:8080';
  
  constructor() { }

  getBorrowedItems(employeeId: number): Observable<BorrowedItemsResponse> {
    return this.http.get<BorrowedItemsResponse>(`${this.apiUrl}/card/${employeeId}`);
  }
}
