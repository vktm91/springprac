let targetId;

$(document).ready(function () {
    // id 가 query 인 녀석 위에서 엔터를 누르면 execSearch() 함수를 실행하라는 뜻입니다.
    $('#query').on('keypress', function (e) {
        if (e.key == 'Enter') {
            execSearch();
        }
    });
    $('#close').on('click', function () {
        $('#container').removeClass('active');
    })

    $('.nav div.nav-see').on('click', function () {
        $('div.nav-see').addClass('active');
        $('div.nav-search').removeClass('active');

        $('#see-area').show();
        $('#search-area').hide();
    })
    $('.nav div.nav-search').on('click', function () {
        $('div.nav-see').removeClass('active');
        $('div.nav-search').addClass('active');

        $('#see-area').hide();
        $('#search-area').show();
    })

    $('#see-area').show();
    $('#search-area').hide();

    showProduct();
})


function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

//////////////////////////////////////////////////////////////////////////////////////////
///// 여기 아래에서부터 코드를 작성합니다. ////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////

function execSearch() {

    $('#search-result-box').empty();
     // * 검색어 input id: query
    let query = $('#query').val();
     // * 검색결과 목록: #search-result-box
    if (query == '') {
        alert("검색어를 입력하세요.");
        $('#query').focus();   //포커스기능
    }

     // * 검색결과 HTML 만드는 함수: addHTML
    // 1. 검색창의 입력값을 가져온다.
    $.ajax({
        tupe: 'GET',
        url: `api/search?query=${query}`,  //백틱주의!
        success: function (response) {
            for (let i=0; i<response.length; i++) {
                let itemDto = response[i];
                let tempHtml = addHTML(itemDto)
                $('#search-result-box').append(tempHtml);
            }
        }

    })
    // 2. 검색창 입력값을 검사하고, 입력하지 않았을 경우 focus.
    // 3. GET /api/search?query=${query} 요청
    // 4. for 문마다 itemDto를 꺼내서 HTML 만들고 검색결과 목록에 붙이기!

}

function addHTML(itemDto) {
    /**
     * class="search-itemDto" 인 녀석에서
     * image, title, lprice, addProduct 활용하기
     * 참고) onclick='addProduct(${JSON.stringify(itemDto)})'
     */
    return `<div class="search-itemDto">
                <div class="search-itemDto-left">
                    <img src="${itemDto.image}" alt="">
                </div>
                <div class="search-itemDto-center">
                    <div>${itemDto.title}</div>
                    <div class="price">
                        ${numberWithCommas(itemDto.lprice)}
                        <span class="unit">원</span>
                    </div>
                </div>
                <div class="search-itemDto-right">
                    <img src="images/icon-save.png" alt="" onclick='addProduct(${JSON.stringify(itemDto)})'>  
<!--                    //괄호안에는 문자열을 써야하므로 json형태 그대로 넣으면 오류나기때문에 스트링형태로 넣어준다-->
                </div>
            </div>`
}

function addProduct(itemDto) {
    /**
     * modal 뜨게 하는 법: $('#container').addClass('active');
     * data를 ajax로 전달할 때는 두 가지가 매우 중요
     * 1. contentType: "application/json",
     * 2. data: JSON.stringify(itemDto),
     *console.log(itemDto);   이것과
     *console.log(JSON.stringify(itemDto));    이것이 다르게 찍히는걸 알 수 있음
     *
     */
    // 1. POST /api/products 에 관심 상품 생성 요청
    $.ajax({
        type: "POST",
        url: '/api/products',
        contentType: "application/json",
        data: JSON.stringify(itemDto),
        success: function (response) {
            // 2. 응답 함수에서 modal을 뜨게 하고, targetId 를 reponse.id 로 설정 (숙제로 myprice 설정하기 위함)
            $('#container').addClass('active');
            targetId = response.id;   //쪼 위쪽에 targetId 변수설정 되어있음
        }
    })
}




function showProduct() {
    /**
     * 관심상품 목록: #product-container
     * 검색결과 목록: #search-result-box
     * 관심상품 HTML 만드는 함수: addProductItem
     */
    // 1. GET /api/products 요청
    // 1. GET /api/products 요청
    $.ajax({
        type: 'GET',
        url: '/api/products',
        success: function (response) {

        }
    })
    // 2. 관심상품 목록, 검색결과 목록 비우기
    $('#product-container').empty();
    $('#search-result-box').empty();
    // 3. for 문마다 관심 상품 HTML 만들어서 관심상품 목록에 붙이기!
    for (let i = 0; i < response.length; i++) {
        let product = response[i];
        let tempHtml = addProductItem(product);
        $('#product-container').append(tempHtml);
    }
}

function addProductItem(product) {
    // link, image, title, lprice, myprice 변수 활용하기
    return `<div class="product-card" onclick="window.location.href='${product.link}'">
            <div class="card-header">
                <img src="${product.image}"
                     alt="">
            </div>
            <div class="card-body">
                <div class="title">
                    ${product.title}
                </div>
                <div class="lprice">
                    <span>${numberWithCommas(product.lprice)}</span>원
                </div>
                <div class="isgood ${product.lprice > product.myprice ? 'none' : ''}">   <!--//삼항연산자/  (조건) ? (참일경우반환) : (거짓일경우반환);  -->
<!--      즉 참일경우 index파일 <div class="isgood">에 none이 되어서 isgood none이 되어 dispaly:none; 적용되어 안보이게됨
거짓일경우 ''아무것도 반환안해서 isgood(최저가마크)이 그대로 뜨게 해줌          -->
<!--product 클래스 만들때 myprice기본적으로 0넣어주도록 해놨음-->
                    최저가
                </div>
            </div>
        </div>`;
}

function setMyprice() {
    /**
     * 숙제! myprice 값 설정하기.
     * 1. id가 myprice 인 input 태그에서 값을 가져온다.
     * 2. 만약 값을 입력하지 않았으면 alert를 띄우고 중단한다.
     * 3. PUT /api/products/${targetId} 에 data를 전달한다.
     *    주의) contentType: "application/json",
     *         data: JSON.stringify({myprice: myprice}),
     *         빠뜨리지 말 것!
     * 4. 모달을 종료한다. $('#container').removeClass('active');
     * 5, 성공적으로 등록되었음을 알리는 alert를 띄운다.
     * 6. 창을 새로고침한다. window.location.reload();
     */
        // 1. id가 myprice 인 input 태그에서 값을 가져온다.
    let myprice = $('#myprice').val();
    // 2. 만약 값을 입력하지 않았으면 alert를 띄우고 중단한다.
    if (myprice == '') {
        alert('올바른 가격을 입력해주세요');
        return;
    }
    // 3. PUT /api/product/${targetId} 에 data를 전달한다.
    $.ajax({
        type: "PUT",
        url: `/api/products/${targetId}`,
        contentType: "application/json",
        data: JSON.stringify({myprice: myprice}),
        success: function (response) {
            // 4. 모달을 종료한다. $('#container').removeClass('active');
            $('#container').removeClass('active');
            // 5. 성공적으로 등록되었음을 알리는 alert를 띄운다.
            alert('성공적으로 등록되었습니다.');
            // 6. 창을 새로고침한다. window.location.reload();
            window.location.reload();
        }
    })
}