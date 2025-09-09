// クリアボタンの処理
const searchForm = document.getElementById("searchParameters");   
const clearBtn = document.getElementById("clearBtn"); 

clearBtn.addEventListener("click", function() {
  
    const inputs = searchParameters.querySelectorAll('input[type="text"], select');
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
// DOM読み込み後に実行
document.addEventListener('DOMContentLoaded', function() {
    
    const buttons = document.querySelectorAll('.incrementBtn');
    buttons.forEach(button => {
        button.addEventListener('click', function() {
            // data-idをし取得
            const id = this.dataset.id;
            incrementVendingMachine(id);
        });
    });
});

function incrementVendingMachine(id) {
    fetch('/increment', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        // 取得したid
        body: `id=${id}`
    })
    // レスポンスをJSONとして処理
    .then(response => response.json())
    // 成功時
    .then(newValue => {
        // 更新する行を特定して値を更新
        const row = document.querySelector(`button[data-id="${id}"]`).closest('tr');
        const vendingMachineCell = row.querySelector('.vendingMachine');
        vendingMachineCell.textContent = newValue;
    })
    // 失敗時
    .catch(error => {
        console.error('Error:', error);
        alert('更新に失敗しました');
    });
}