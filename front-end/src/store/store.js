import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    //strict: true,
    state: {
        userID:'',
        userName: '',
        userImage: "",
        role:""
    },
    getters: {
        
    },
    mutations: {
      initialiseStore(state) {
        if (localStorage.getItem('userID') ) {
            state.userID = localStorage.getItem('userID');
            state.userName = localStorage.getItem('userName');
            state.userImage = localStorage.getItem('userImage');
        }
      },
      saveUserData:(state , data) =>{
        console.log("vvvvvvvv");
        state.userID = data._id;
        state.userName = data._name;
        state.role = data._role;
        localStorage.setItem('userID', data._id);
        localStorage.setItem('userName', data._name);
      },

    },
    actions: {
    },
    
});

/*
const getDefaultState = () => {
    return {
    }
};

function parseJSON(resp) {
    return resp.json();
}

function parseText(resp) {
    return resp.text();
}

function checkStatus(resp) {
    console.log('status');
    if (resp.status >= 200 && resp.status < 300) {
        console.log('good status');
        return resp;
    }
    console.log('bad status');
    return this.parseJSON(resp).then((resp) => {
        throw resp;
    });
}
*/