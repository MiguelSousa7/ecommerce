import type { Category } from "./CategoryType";

export type Product = {
  id: number;
  name: string;
  description: string;
  imageUrl: string;
  price: number;
  category: Category;
};