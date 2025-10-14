import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { LoginService, LoginRequest } from '../../services/login.service';


@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.scss'
})
export class Login {
    credentials: LoginRequest = {
    username: '',
    password: ''
  };

  verification: boolean = true;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {}

  onLogin(frm: NgForm) {

    if (frm.valid) {
      this.loginService.login(this.credentials).subscribe({
        next: (response) => {
          console.log('Login bem-sucedido:', response);
          this.verification = true;
          if (response.token) {
            localStorage.setItem('token', response.token);
            this.router.navigate(['/home']);
          }
        },
        error: (error) => {
          console.error('Erro no login:', error);
          this.verification = false;
        }
      });
    }
  }
  
}
