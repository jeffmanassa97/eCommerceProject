<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Page</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1"
    />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link
      href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800"
      rel="stylesheet"
      type="text/css"
    />
    <script type="application/x-javascript">
      addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
    </script>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
      $(document).ready(function() {
        $(".dropdown img.flag").addClass("flagvisibility");

        $(".dropdown dt a").click(function() {
          $(".dropdown dd ul").toggle();
        });

        $(".dropdown dd ul li a").click(function() {
          var text = $(this).html();
          $(".dropdown dt a span").html(text);
          $(".dropdown dd ul").hide();
          $("#result").html("Selected value is: " + getSelectedValue("sample"));
        });

        function getSelectedValue(id) {
          return $("#" + id)
            .find("dt a span.value")
            .html();
        }

        $(document).bind("click", function(e) {
          var $clicked = $(e.target);
          if (!$clicked.parents().hasClass("dropdown"))
            $(".dropdown dd ul").hide();
        });

        $("#flagSwitcher").click(function() {
          $(".dropdown img.flag").toggleClass("flagvisibility");
        });
      });
    </script>
    <!-- --details-product-slider- -->
    <!-- Include the Etalage files -->
    <link rel="stylesheet" href="css/etalage.css" />
    <script src="js/jquery.etalage.min.js"></script>
    <!-- Include the Etalage files -->
    <script>
      jQuery(document).ready(function($) {
        $("#etalage").etalage({
          thumb_image_width: 300,
          thumb_image_height: 400,

          show_hint: true,
          click_callback: function(image_anchor, instance_id) {
            alert(
              'Callback example:\nYou clicked on an image with the anchor: "' +
                image_anchor +
                '"\n(in Etalage instance: "' +
                instance_id +
                '")'
            );
          }
        });
        // This is for the dropdown list example:
        $(".dropdownlist").change(function() {
          etalage_show(
            $(this)
              .find("option:selected")
              .attr("class")
          );
        });
      });
    </script>
    <!-- --//details-product-slider- -->
  </head>
<body>
   <div class="header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="header-left">
              <div class="logo">
                <a href="index.html"><img src="images/logo.png" alt=""/></a>
              </div>
              <div class="menu">
                <a class="toggleMenu" href="#"
                  ><img src="images/nav.png" alt=""
                /></a>
                <ul class="nav" id="nav">
                  <li class="current"><a href="shop.jsp">Shop</a></li>
                  <li><a href="contact.jsp">Contact</a></li>
                  <div class="clear"></div>
                </ul>
                <script
                  type="text/javascript"
                  src="js/responsive-nav.js"
                ></script>
              </div>
              <div class="clear"></div>
            </div>
            <div class="header_right">
              <!-- start search -->
              <div class="search-box">
                <div id="sb-search" class="sb-search">
                  <form>
                    <input
                      class="sb-search-input"
                      placeholder="Enter your search term..."
                      type="search"
                      name="search"
                      id="search"
                    />
                    <input class="sb-search-submit" type="submit" value="" />
                    <span class="sb-icon-search"> </span>
                  </form>
                </div>
              </div>
              <!-- --search-scripts-- -->
              <script src="js/classie.js"></script>
              <script src="js/uisearch.js"></script>
              <script>
                new UISearch(document.getElementById("sb-search"));
              </script>
              <ul class="icon1 sub-icon1 profile_img">
                <li>
                  <a class="active-icon c1" href="#"> </a>
                  <ul class="sub-icon1 list">
                    <div class="product_control_buttons">
                      <a href="#"><img src="images/edit.png" alt=""/></a>
                      <a href="#"><img src="images/close_edit.png" alt=""/></a>
                    </div>
                    <div class="clear"></div>
                    <li class="list_img"><img src="images/1.jpg" alt="" /></li>
                    <li class="list_desc">
                      <h4><a href="#">velit esse molestie</a></h4>
                      <span class="actual">1 x $12.00</span>
                    </li>
                    <div class="login_buttons">
                      <div class="check_button">
                        <a href="checkout.html">Check out</a>
                      </div>
                      <div class="login_button">
                        <a href="login.html">Login</a>
                      </div>
                      <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                  </ul>
                </li>
              </ul>
              <div class="clear"></div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="main">
      <div class="shop_top">
        <div class="container">
          <div class="row">
            <div class="col-md-9 single_left">
              <div class="single_image">
                <ul id="etalage">
                  <li>
                      <img class="etalage_source_image" src="${ImageURL}" />
                  </li>
                </ul>
              </div>
              <!-- end product_slider -->
              <div class="single_right">
          
                
                <ul class="add-to-links">
                  <li></li>
                </ul>
              </div>
              <div class="clear"></div>
            </div>
            <div class="col-md-3">
              <div class="box-info-product"><p class="price2">$${Cost}</p>
              
              <div class="btn_form">
                  <form action="OrderReview" method="post" name="order" id="login-form">
                  
                  <button
                  type="submit"
                  name="order1"
                  class="button"
                  value="${SKU}"> Buy Now </button>
                                  
                 </form>
                </div>
              
              </div>
            </div>
          </div>
          <div class="desc">
            <h4>${Name}</h4>
            <p>
              ${Description} <br>
              In Stock: ${Count} <br>
              Brand: ${Brand} <br>
              Features: <br>
              ${Type} <br>
              ${Year} <br>
              ${String} <br>
              Hertz: ${Hertz} <br>
              Subs: ${Subs}
              
            </p>
            <br> <br>
            <form
                  action="ReviewServlet"
                  method="post"
                  name="review"
                  id="review-form"
                >
                  <fieldset class="input">
                    <p id="login-form-username">
                      <label for="modlgn_username">Review Title</label>
                      <input
                        id="modlgn_username"
                        type="text"
                        name="title"
                        class="inputbox"
                        size="18"
                        autocomplete="off"
                      />
                      <label for="modlgn_username">Review Stars (0-5)</label>
                      <input
                        id="modlgn_username"
                        type="text"
                        name="stars"
                        class="inputbox"
                        size="18"
                        autocomplete="off"
                      />
                      <label for="modlgn_username">Review Body</label>
                      <input
                        id="modlgn_username"
                        type="text"
                        name="review_body"
                        class="inputbox"
                        size="18"
                        autocomplete="off"
                      />
                    </p>
                                      
                  <button
                  type="submit"
                  name="review1"
                  class="button"
                  value="${SKU}"> Submit Review </button>
                                  
                      
                      <div class="clear"></div>
                    </div>
                  </fieldset>
                </form>
                <h4> 
                Product Reviews: <br> <br>
                </h4>
                
                <p>
                Customer: ${customer_id1} <br> 
                Posted on ${timestamp1} <br>
                Title: ${title1} <br>
                Stars: ${stars1} <br>
                ${review_body1} <br>
                <br>
                
                
                
                </p>  
          </div>
         <div class="row">
            <h4 class="m_11">Best Selling Product</h4>
            <div class="col-md-4 product1">
              <img src=${best_imageurl} class="img-responsive" alt="" />
              <div class="shop_desc">
                <a href="single.html"> </a>
                <h3><a href="single.html"></a><a href="#">${best_name}</a></h3>
                <p>${best_description}</p>
                <span class="actual">$${best_cost}</span><br />
                <ul class="buttons">
                  <li class="shop_btn"><a href="#">Read More</a></li>
                  <div class="clear"></div>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>Products</h4>
              <li><a href="#">Mens</a></li>
              <li><a href="#">Womens</a></li>
              <li><a href="#">Youth</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>About</h4>
              <li><a href="#">Careers and internships</a></li>
              <li><a href="#">Sponserships</a></li>
              <li><a href="#">team</a></li>
              <li><a href="#">Catalog Request/Download</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>Customer Support</h4>
              <li><a href="#">Contact Us</a></li>
              <li><a href="#">Shipping and Order Tracking</a></li>
              <li><a href="#">Easy Returns</a></li>
              <li><a href="#">Warranty</a></li>
              <li><a href="#">Replacement Binding Parts</a></li>
            </ul>
          </div>
          <div class="col-md-3">
            <ul class="footer_box">
              <h4>Newsletter</h4>
              <div class="footer_search">
                <form>
                  <input
                    type="text"
                    value="Enter your email"
                    onfocus="this.value = '';"
                    onblur="if (this.value == '') {this.value = 'Enter your email';}"
                  />
                  <input type="submit" value="Go" />
                </form>
              </div>
              <ul class="social">
                <li class="facebook">
                  <a href="#"><span> </span></a>
                </li>
                <li class="twitter">
                  <a href="#"><span> </span></a>
                </li>
                <li class="instagram">
                  <a href="#"><span> </span></a>
                </li>
                <li class="pinterest">
                  <a href="#"><span> </span></a>
                </li>
                <li class="youtube">
                  <a href="#"><span> </span></a>
                </li>
              </ul>
            </ul>
          </div>
        </div>
        <div class="row footer_bottom">
          <div class="copy">
            <p>
              © 2014 Template by
              <a href="http://w3layouts.com" target="_blank">w3layouts</a>
            </p>
          </div>
          <dl id="sample" class="dropdown">
            <dt>
              <a href="#"><span>Change Region</span></a>
            </dt>
            <dd>
              <ul>
                <li>
                  <a href="#"
                    >Australia<img
                      class="flag"
                      src="images/as.png"
                      alt=""
                    /><span class="value">AS</span></a
                  >
                </li>
                <li>
                  <a href="#"
                    >Sri Lanka<img
                      class="flag"
                      src="images/srl.png"
                      alt=""
                    /><span class="value">SL</span></a
                  >
                </li>
                <li>
                  <a href="#"
                    >Newziland<img
                      class="flag"
                      src="images/nz.png"
                      alt=""
                    /><span class="value">NZ</span></a
                  >
                </li>
                <li>
                  <a href="#"
                    >Pakistan<img
                      class="flag"
                      src="images/pk.png"
                      alt=""
                    /><span class="value">Pk</span></a
                  >
                </li>
                <li>
                  <a href="#"
                    >United Kingdom<img
                      class="flag"
                      src="images/uk.png"
                      alt=""
                    /><span class="value">UK</span></a
                  >
                </li>
                <li>
                  <a href="#"
                    >United States<img
                      class="flag"
                      src="images/us.png"
                      alt=""
                    /><span class="value">US</span></a
                  >
                </li>
              </ul>
            </dd>
          </dl>
        </div>
      </div>
    </div>
  </body>

</html>