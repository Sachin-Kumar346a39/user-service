import { UserInfo } from './../user-info.model';
import { TestBed, async, inject } from '@angular/core/testing';


import { ValidateUserService } from './validate-user.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('ValidateUserService', () => {
  let service: ValidateUserService;
  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      providers: [UserInfo]
    });
    service = TestBed.inject(ValidateUserService);
    httpMock = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });



  it(`should return posts as an Observable`, async(inject([HttpTestingController, ValidateUserService],
    () => {

      let POST_URL = 'http://localhost:9090/api/v1/user/validateUser'
      const postUser = [
        {
          "username": "user@sw.com",
          "password": "",
          "admin": false
        }
      ];
      let userInfo = new UserInfo;
      service.validate(userInfo)
        .subscribe((data: any) => {
          expect(data.length).toBe(1);
        });

      let req = httpMock.expectOne(POST_URL);
      expect(req.request.method).toBe("POST");

      req.flush(postUser);
      httpMock.verify();

    })));


});
