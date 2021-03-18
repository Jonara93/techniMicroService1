import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  formLogin: FormGroup;

  constructor(private _formBuilder: FormBuilder,
    private _router: Router,
    private _authService: AuthService) { }

  ngOnInit(): void {
    this.formLogin = this._formBuilder.group({
      pseudo: ['', Validators.required],
      password: ['', Validators.required]
    })
  }

  login() {
    if (this.formLogin.valid)
      this._authService.login(this.formLogin.value['pseudo'], this.formLogin.value['password'])
  }

}
