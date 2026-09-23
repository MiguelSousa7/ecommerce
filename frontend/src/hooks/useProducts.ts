import { useState, useEffect } from "react";
import type {Product} from "@/types/ProductType";

export const useProducts = () => {
  const [products, setProducts] = useState<Product[]>([]);

  useEffect(() => {
    fetch("http://localhost:8080/api/products")
      .then((response) => response.json())
      .then((data) => setProducts(data));
  }, []);

  return { products };
};
