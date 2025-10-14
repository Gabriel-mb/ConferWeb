import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Home } from './components/home/home';
import { Card } from './components/card/card';
import { Employees } from './components/employees/employees';
import { Equipments } from './components/equipments/equipments';
import { Supplies } from './components/supplies/supplies';
import { Ppe } from './components/ppe/ppe';

export const routes: Routes = [
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    {path: "login", component: Login},
    {path: "home", component: Home},
    {path: "card/:id", component: Card},
    {path: "employees", component: Employees},
    {path: "equipments", component: Equipments},
    {path: "supplies", component: Supplies},
    {path: "ppe", component: Ppe}

];
