import {Component} from '@angular/core';
import {ProductService} from "./services/product.service";

@Component({
  selector: 'search-field',
  template: `
    <input #query (keyup)="submit(query.value)" >
    <p>{{values}}</p>
  `,
  providers: [ProductService]
})
export class SearchFieldComponent {
  values = '';

  constructor(private productService: ProductService) {
  }

  submit(query: string) { // with type info
    this.values = query;
    //this.productService
  }
}
