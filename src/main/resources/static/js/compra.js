
function verFactura(){
  let base_url = "https://ecommerce-production-5d12.up.railway.app";
  const facturaId = window.location.pathname.split("/")[2];

  window.location.href = base_url+"/factura/"+facturaId;
} 

