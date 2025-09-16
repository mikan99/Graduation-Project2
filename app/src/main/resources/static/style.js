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

// 自販機使用回数ボタンの処理
document.addEventListener('click', function(e){
  const id = e.target.dataset.id;
  const countEl = document.getElementById('count-' + id);
  const vendingMachine = Number(countEl.textContent);
  
  // 増加ボタン
  if (e.target.classList.contains('incrementBtn')) {
      if(vendingMachine == 2){
        return;
      }
      fetch(`/members/${id}/increment`, { method: 'POST', credentials: 'same-origin' })
        .then(res => {
          if (!res.ok) throw new Error('更新失敗');
          countEl.textContent = String(vendingMachine + 1);
        })
        .catch(err => alert(err));
  }
  // 減少ボタン
  if (e.target.classList.contains('decrementBtn')) {
      if(vendingMachine == 0){
        return;
      }
      fetch(`/members/${id}/decrement`, { method: 'POST', credentials: 'same-origin' })
        .then(res => {
          if (!res.ok) throw new Error('更新失敗');
          countEl.textContent = String(vendingMachine - 1);
        })
        .catch(err => alert(err));
  }
});