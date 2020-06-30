import { TestBed } from '@angular/core/testing';

import { RouterTestingModule } from '@angular/router/testing';

import { ValidateUserService } from './validate-user.service';

describe('ValidateUserService', () => {
  let service: ValidateUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule.withRoutes([]),
      ],
    });
    service = TestBed.inject(ValidateUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
