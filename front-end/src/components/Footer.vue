<template>
  <div id="footer-container">
  <!-- Site footer -->
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div style="margin:20px">
            <h2>About</h2>
            <p class="text-justify">mozark.com is an E-commerce Website</p>
          </div>

          <div style="margin:20px">
            <h2>Quick Links</h2>
            <ul class="footer-links">
              <li><a href="https://github.com/MohamedMetwalli5/MOZARK" style="font-size: 15px">About Us</a></li>
              <li><a href="https://github.com/MohamedMetwalli5/MOZARK" style="font-size: 15px">Contact Us</a></li>
            </ul>
          </div>
        </div>
        <hr>
      </div>
      <div class="container">
        <div class="row">
          <div style="margin:20px">
            <p class="copyright-text">Copyright &copy; 2021 All Rights Reserved by 
             <a href="https://github.com/MohamedMetwalli5/MOZARK">MOZARK</a>.
            </p>
          </div>

          <div class="col-md-4 col-sm-6 col-xs-12">
            <ul class="social-icons">
                <li>
                    <a id="linkedin-icon"
                        href="https://www.linkedin.com/in/mohamed-metwalli5/"
                        target="_blank"
                        ><fa-icon :icon="['fab', 'linkedin']" size="3x" id="linkedin"/>
                    </a> <!-- for contacting the project front-end developer -->
                    <a id="github-icon"
                        href="https://github.com/MohamedMetwalli5/MOZARK" 
                        target="_blank"
                    ><fa-icon :icon="['fab', 'github-square']" size="3x" id="github"/> <!-- for contacting the project link -->
                    </a>
                </li>
            </ul>
            
          </div>
        </div>
      </div>
</footer>
  </div>
</template>

<script>
export default {
  name: "Footer",
  props: {
    msg: String,
  },
  data() {
    return {
    };
  },
  methods: {
  },
};
</script>

<style scoped>.site-footer
{
  background-color:#26272b;
  padding:45px 0 20px;
  font-size:15px;
  line-height:24px;
  color:#737373;
}
.site-footer hr
{
  border-top-color:#bbb;
  opacity:0.5
}
.site-footer hr.small
{
  margin:20px 0
}
.site-footer h2
{
  color:#fff;
  font-size:16px;
  text-transform:uppercase;
  margin-top:5px;
  letter-spacing:2px
}
.site-footer a
{
  color:#737373;
}
#linkedin :hover
{
  color:#4f86f3;
  text-decoration:none;
}
#github-icon :hover
{
  color:#c2c2c2;
  text-decoration:none;
}
.footer-links
{
  padding-left:0;
  list-style:none
}
.footer-links li
{
  display:block
}
.footer-links a
{
  color:#737373
}

.footer-links.inline li
{
  display:inline-block
}
.site-footer .social-icons
{
  text-align:left
}
.site-footer .social-icons a
{
  width:40px;
  height:40px;
  line-height:40px;
  margin-left:6px;
  margin-right:0;
  border-radius:100%;
  background-color:#33353d
}
.copyright-text
{
  margin:0
}

@media (max-width:767px)
{
  .copyright-text,.site-footer .social-icons
  {
    text-align:center
  }
}
.social-icons
{
  padding-left:0;
  margin:20px;
  list-style:none
}




</style>
