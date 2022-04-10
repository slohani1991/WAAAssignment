const Product = (props) => {
  return (
    <div>
      <h3>Product Name : {props.name}</h3>
      <p>Price : ${props.price}</p>
    </div>
  );
};

export default Product;
