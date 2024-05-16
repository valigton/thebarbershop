import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { provideAnimations } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser'
import { provideNativeDateAdapter } from '@angular/material/core';
import { FormsModule ,ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { CommonModule } from '@angular/common';

import { InputMaskModule } from '@ngneat/input-mask';

import { routes } from './app.routes';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideHttpClient(),
    provideAnimations(),
    provideNativeDateAdapter(),
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    CommonModule,
    InputMaskModule
  ]
};
