import ProductList from '@/components/ProductList';
import { useProducts } from "@/hooks/useProducts";

export default function ProductListScreen() {
    const { products } = useProducts(); 

    return (
        <div>
            {products.length ? (
                <div>
                    <ProductList products={products}/>
                </div>
            ): (
                <p>No products found</p> 
            )}
        </div>
    )
}
