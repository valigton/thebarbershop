import { Routes } from '@angular/router';
import { HomeComponent } from "./components/home/home.component"
import { SchedulingComponent } from './components/scheduling/scheduling.component';
import { ConsultComponent } from './components/consult/consult.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { ConsultServiceComponent } from './components/consult-service/consult-service.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'agendamento', component: SchedulingComponent },
  { path: 'agendamento/:id', component: SchedulingComponent },
  { path: 'consulta', component: ConsultComponent },
  { path: 'consulta-servico', component: ConsultServiceComponent },
  {path: '**', component: PageNotFoundComponent},
];

