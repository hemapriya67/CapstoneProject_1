import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

@pytest.fixture
def browser():
    # Initialize the WebDriver
    driver = webdriver.Chrome()
    driver.implicitly_wait(10)
    yield driver
    driver.quit()

def open_browser(browser):
    # Step 1: Launch the URL
    browser.get("https://www.flipkart.com/")
    browser.maximize_window()
    browser.delete_all_cookies()
    browser.set_page_load_timeout(10)

    # Verify that "Flipkart" is present on the left side of the top
    assert browser.find_element(By.XPATH, "//img[@class='aqQN50']").is_displayed()

    # Step 2: Enter "Macbook air m2" in the search text box and search
    #//*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/div/input
    search_box = browser.find_element(By.xpath, "//*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/div/input")
    search_box.send_keys("Macbook air m3")
    search_box.send_keys(Keys.RETURN)
    search_icon = browser.find_element(By.xpath, "//*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/button")
    search_icon.click();
    #//*[@id="container"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/button

    # Step 3: Click on the first displayed item
    first_item = WebDriverWait(browser, 10).until(
        EC.presence_of_element_located((By.XPATH, "//*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a"))
    )
    item_From_Search_Result_Page = browser.find_element(By.XPATH, "//*[@id="container"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]").text
    first_item.click()
    print(item_From_Search_Result_Page)

    # Step 4: Switch to next window
    current_Win_Id = browser.current_window_handle
    allWinId = browser.window_handles
    for winId in allWinId:
        if winId != current_Win_Id:
            browser.switch_to.window(winId)

    # Step 5: Click on "Add To Cart" button
    #//*[@id="container"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button
    add_to_cart_button = WebDriverWait(browser, 10).until(
        EC.presence_of_element_located(By.XPATH, "//*[@id='container']/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")
    )
    add_to_cart_button.click()

    # Step 5: Verify that the item has been added to the cart successfully
    WebDriverWait(browser, 10)
    cart_icon = browser.find_element(By.XPATH, "//*[@id="container"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a")
    cart_icon.click()
    cart_Page= browser.find_element(By.XPATH, "//a[@class = '_2Kn22P gBNbID']").text
    print(cart_Page)
    assert cart_Page == item_From_Search_Result_Page

if __name__ == "__main__":
    pytest.main()