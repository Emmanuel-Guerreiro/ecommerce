document.getElementById("search-form").addEventListener("submit", function (e) {
  e.preventDefault();
  let param = document.getElementById("search-input").value;
  let url = `/productos?nombre=${encodeURIComponent(param)}`;
  window.location = url;
});
