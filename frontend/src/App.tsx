import { useEffect, useState } from 'react'
import './App.css'
import ProductList from './components/ProductList';

function App() {
    const [products, setProducts] = useState([]); 

    useEffect(() => {
        fetch('http://localhost:8080/api/products')
            .then(response => response.json())
            .then(data => setProducts(data));
    }, []);
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

export default App
