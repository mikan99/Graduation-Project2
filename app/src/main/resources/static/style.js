// クリアボタンの処理
const searchForm = document.getElementById("searchForm");   
const clearBtn = document.getElementById("clearBtn"); 

clearBtn.addEventListener("click", function() {
  
    const inputs = searchForm.querySelectorAll('input[type="text"], select');
    inputs.forEach(element => {
         switch (element.type) {
            case "text":
                element.value = "";
                break;
            case "select-one":
                element.selectedIndex = 0;
                break;
            }
        });
    });


// 自販機使用回数増加ボタンの処理
document.addEventListener('click', function(e){
  // 増加ボタン
  if (e.target.classList.contains('incrementBtn')) {
      const id = e.target.dataset.id;
      fetch(`/members/${id}/increment`, { method: 'POST', credentials: 'same-origin' })
        .then(res => {
          if (!res.ok) throw new Error('更新失敗');
          const countEl = document.getElementById('count-' + id);
          countEl.textContent = String(Number(countEl.textContent) + 1);
        })
        .catch(err => alert(err));
  }

  // 減少ボタン
  if (e.target.classList.contains('decrementBtn')) {
      const id = e.target.dataset.id;
      fetch(`/members/${id}/decrement`, { method: 'POST', credentials: 'same-origin' })
        .then(res => {
          if (!res.ok) throw new Error('更新失敗');
          const countEl = document.getElementById('count-' + id);
          countEl.textContent = String(Math.max(Number(countEl.textContent) - 1, 0)); // 0未満にならないように
        })
        .catch(err => alert(err));
  }
});