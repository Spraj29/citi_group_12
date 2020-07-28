import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SavedDataComponent } from './saved-data.component';

describe('SavedDataComponent', () => {
  let component: SavedDataComponent;
  let fixture: ComponentFixture<SavedDataComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SavedDataComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SavedDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
