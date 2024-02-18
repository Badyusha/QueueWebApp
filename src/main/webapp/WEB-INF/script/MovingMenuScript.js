document.addEventListener("DOMContentLoaded", function() {
    var menuIcon = document.getElementById("menuIcon");
    var menu = document.getElementById("menu");
    var isMenuVisible = false;

    menuIcon.addEventListener("click", function() {
        isMenuVisible = !isMenuVisible;

        if (isMenuVisible) {
            menu.style.transform = "translateX(0)";
            menuIcon.style.marginRight = "220px"; /* Измените значение на нужное вам */
        } else {
            menu.style.transform = "translateX(100%)";
            menuIcon.style.marginRight = "20px"; /* Измените значение на начальное */
        }
    });

    document.addEventListener("click", function(event) {
        var isClickInsideMenu = menu.contains(event.target);
        var isClickOnIcon = menuIcon.contains(event.target);

        if (!isClickInsideMenu && !isClickOnIcon && isMenuVisible) {
            isMenuVisible = false;
            menu.style.transform = "translateX(100%)";
            menuIcon.style.marginRight = "20px"; /* Измените значение на начальное */
        }
    });
});