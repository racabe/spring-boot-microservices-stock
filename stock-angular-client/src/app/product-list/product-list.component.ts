import { Component, OnInit } from '@angular/core';
import { ProductService } from '../shared';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css'],
  providers: [ProductService]
})
export class ProductListComponent implements OnInit {
  products: Array<any>;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts = function() {
    this.productService.getAll().subscribe(
      data => {
        this.products = data;
      },
      error => console.log(error)
    )
  }

  updateProduct = function(product) {
    this.productService.updateProduct(product).subscribe(
      data => {
      },
      error => console.log(error)
    )
  }

  addProduct = function(product) {
    product.amount++;
    this.updateProduct(product);
  }

  removeProduct = function(product) {
    if (product.amount > 0) {
      product.amount--;
      this.updateProduct(product);
    }
  }
}
