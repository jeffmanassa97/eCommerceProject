<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop</title>
</head>
<title>Shop</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
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
                return $("#" + id).find("dt a span.value").html();
            }

            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("dropdown"))
                    $(".dropdown dd ul").hide();
            });


            $("#flagSwitcher").click(function() {
                $(".dropdown img.flag").toggleClass("flagvisibility");
            });
        });
     </script>
</head>
<body>
    <div class="header">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="header-left">
              <div class="logo">
                <img src="images/logo.png" alt=""/>
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
        <form action="ProductPage" method="post" name="data" id="product-form">
          <div class="container">
            <div class="row shop_box-top">
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p1"
                >
                  <img src="images/pic1.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Yamaha F335 Acoustic Guitar</h3>
                    <p>Yamaha’s F335 gives you a sharp sound that is very durable. This guitar gives you a great guitar while not hurting your pockets.</p>
                    
                    <span class="actual">$159.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p2"
                >
                  <img src="images/pic2.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Washburn WA90CE Dreadnought Acoustic Electric Guitar</h3>
                    <p>The Washburn WA90CE gives you the look that you’ve always wanted for a guitar. Its appealing look is just as good as its performance. </p>
                    <span class="actual">$169.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p3"
                >
                  <img src="images/pic3.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Washburn RO10 Rover Travel Acoustic Guitar Transparent Blue</h3>
                    <p>This guitar is extremely useful to guitarist who are always on the road due to its slim style. Its vibrant blue look is what will make your guitar stand out from the others.  </p>
                    <span class="actual">$189.00 </span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p4"
                >
                  <img src="images/pic4.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Martin Custom D Classic Mahogany Dreadnought Acoustic Guitar</h3>
                    <p>This classic guitar is for the serious guitarists who live and breath music. This is a great Beige all around guitar that is worth the price.</p>
                    <span class="actual">$999.00</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p5"
                >
                  <img src="images/pic5.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Martin GPC-15ME Street Master Special Grand Performance Acoustic-Electric Guitar Natural</h3>
                    <p>This beautiful guitar is what every guitarist desire to have in their inventory. This guitar is worth the price due to the superb quality.</p>
                    <span class="actual">$999.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p6"
                >
                  <img src="images/pic6.png" class="img-responsive" alt="" />
                  <span class="new-box">
                  </span>
                  <span class="sale-box">
                    <span class="sale-label">Sale!</span>
                  </span>
                  <div class="shop_desc">
                    <h3>Fender Limited Edition Standard Stratocaster HSS Plus Top Maple Fingerboard Electric Guitar Blue Burst</h3>
                    <p>This guitar is for guitarists who appreciate the style and richness of an amazing guitar. This guitar gives you amazing quality along with looks</p>
                    <span class="actual">$599.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p7"
                >
                  <img src="images/pic7.png" class="img-responsive" alt="" />
                  <span class="new-box">
                  </span>
                  <span class="sale-box">
                    <span class="sale-label">Sale!</span>
                  </span>
                  <div class="shop_desc">
                    <h3>Fender Player Stratocaster Maple Fingerboard Electric Guitar</h3>
                    <p>This white guitar will make you stand out from everyone else. With its sleek and smooth style, you’ll be the life of the party </p>
                    <span class="actual">$649.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p8"
                >
                  <img src="images/pic8.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Gibson Limited Edition Les Paul Traditional Electric Guitar Blueberry Burst </h3>
                    <p>This groovy vintage guitar is the price that it is for a reason. Its calming blue look will have you never wanting to put it down. </p>
                    <span class="actual">$999.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p9"
                >
                  <img src="images/pic9.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Gibson SG Standard 2018 Electric Guitar </h3>
                    <p>This standard electric guitar is one of the most balanced guitars all around. From its price to its performance.</p>
                    <span class="actual">$999.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p10"
                >
                  <img src="images/pic10.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Brian May Guitars Brian May Signature Electric Guitar</h3>
                    <p>Don’t let the low-price fool you, this gorgeous guitar performs like a beauty. The durability of the guitar is what makes the guitar.</p>
                    <span class="actual">$849.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p11"
                >
                  <img src="images/pic11.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Acoustic Lead Guitar Series G20 20W 1x10 Guitar Combo Amp</h3>
                    <p>Two channels 10’ speaker
</p>
                    <span class="actual">$89.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p12"
                >
                  <img src="images/pic12.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Fender Champion 20 Guitar Combo Amp Black</h3>
                    <p>Single Channel 120V
</p>
                    <span class="actual">$99.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p13"
                >
                  <img src="images/pic13.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Marshall DSL40CR 40W 1x12 Tube Guitar Combo Amp</h3>
                    <p>Two Channels
				Single input Built-in reverb
</p>
                    <span class="actual">$749.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p14"
                >
                  <img src="images/pic14.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Fender Mustang I V.2 20W 1x8 Guitar Combo Amp Black</h3>
                    <p>USB Connectivity Chromatic Tuner
</p>
                    <span class="actual">$119.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
              <div class="col-md-3 shop_box">
                <button
                  type="submit"
                  name="submit"
                  class="button"
                  value="p15"
                >
                  <img src="images/pic15.png" class="img-responsive" alt="" />
                  <span class="new-box">
                    <span class="new-label">New</span>
                  </span>
                  <span class="sale-box">
                  </span>
                  <div class="shop_desc">
                    <h3>Boss Katana KTN-50 50W 1x12 Guitar Combo Amplifier Black</h3>
                    <p>Two channels USB B port Built-in tilt stand
</p>
                    <span class="actual">$229.99</span><br />
                    <ul class="buttons">
                      <li class="shop_btn">Read More</li>
                      <div class="clear"></div>
                    </ul>
                  </div>
                </button>
              </div>
            </div>
          </div>
        </form>
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