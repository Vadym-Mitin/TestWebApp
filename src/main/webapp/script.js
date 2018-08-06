function postData(url, data) {
  // Default options are marked with *
  return fetch(url, {
    body: JSON.stringify(data), // must match 'Content-Type' header
    cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
    credentials: 'same-origin', // include, same-origin, *omit
    headers: {
      'content-type': 'text/plain'
    },
    method: 'POST', // *GET, POST, PUT, DELETE, etc.
    mode: 'cors', // no-cors, cors, *same-origin
    redirect: 'follow', // manual, *follow, error
    referrer: 'no-referrer', // *client, no-referrer
  })
  .then(response => response.json()) // parses response to JSON
}

$(document).ready(function() {

   $("#button1").click(function() {
        let value = $('#input1').val();
        postData('/webapp/ask', value)
          .then(function(data) {
                $('#input2').val(data);
          }) // JSON from `response.json()` call
          .catch(error => console.error(error))
    });
})

