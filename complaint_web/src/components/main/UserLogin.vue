<template>
  <div class="hello">
    <div>
      <Top></Top>
    </div>

    <!-- Main content -->
    <section>
      <div class="container">
        <!-- Title -->
        <!-- Section title -->
        <div class="row mb-5 justify-content-center text-center">
          <div class="col-lg-6">

            <h2 class=" mt-4">登入您的账户</h2>
            <div class="mt-2">
              <p class="lead lh-180">Login Your Account</p>
            </div>

            <div>
              <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                  v-model="userLoginBo.username">
              </div>
              <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" v-model="userLoginBo.password">
              </div>
              <div class="form-group form-check">
                <button class="btn btn-primary" style="width:100%" @click="submit()">Submit</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <footer class="position-relative" id="footer-main">
      <Foot></Foot>
    </footer>
  </div>
</template>

<script>
import Foot from '../frame/Foot.vue';
import Top from '../frame/LoginTop.vue'
import { synRequestPost, synRequestGet } from "../../../static/request"

export default {
  name: 'HelloWorld',
  components: {
    Foot, Top
  },
  data() {
    return {
      userLoginBo: {
        username: "",
        password: "",
      },
    }
  },
  mounted() {

  },

  methods: {
    //提交登入
    async submit() {
      if (this.userLoginBo.username == "") {
        alert("用户名不能为空!")
        return
      }
      if (this.userLoginBo.username.length < 3) {
        alert("用户名长度小于3,请重新输入!")
        this.userLoginBo.username = ""
        return
      }
      if (this.userLoginBo.username.length > 30) {
        alert("用户名长度大于30,请重新输入!")
        this.userLoginBo.username = ""
        return
      }

      if (this.userLoginBo.password == "") {
        alert("密码不能为空!")
        return
      }
      var object = await synRequestPost("/user/Login", this.userLoginBo);
      if (object.code != "0x200") {
        alert(object.message);
        return;
      }
      setCookie("token", object.data.jwt);
      alert(object.message);
      localStorage.setItem("role",JSON.stringify(object.data.role))
      this.$router.push("/complaintManagement")

    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}</style>
