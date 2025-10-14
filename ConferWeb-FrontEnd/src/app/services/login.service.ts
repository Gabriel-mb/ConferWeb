import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface LoginRequest {
  username: string;
  password: string;
}

export interface LoginResponse {
  token?: string;
  success: boolean;
}

@Injectable({
  providedIn: 'root'
})

export class LoginService {

  http = inject(HttpClient);

  private apiUrl = 'http://localhost:8080';
  
  constructor() { }

  login(credentials: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(this.apiUrl + "/login", credentials);
  }
}
