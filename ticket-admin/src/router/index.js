import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permsission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'dashboard' }
    }]
  }
]

/**
 * asyncRoutes
 * the routes that need to be dynamically loaded based on user roles
 */
export const asyncRoutes = [
  {
    path: '/scenic',
    component: Layout,
    redirect: '/scenic/list',
    name: '景点管理',
    meta: {
      title: '景点管理',
      icon: 'example'
    },
    children: [
      {
        path: 'list',
        name: '景点列表',
        component: () => import('@/views/scenic/list'),
        meta: {
          title: '景点列表',
          icon: 'example'
        }
      },
      {
        path: 'add',
        name: '添加景点',
        component: () => import('@/views/scenic/add'),
        meta: {
          title: '添加景点',
          icon: 'example'
        }
      },
      {
        path: 'category',
        name: 'scenicCategory',
        component: () => import('@/views/scenic/category/index'),
        meta: {
          title: '分类管理',
          icon: 'example'
        },
        children: [
          {
            path: 'list',
            name: 'scenicCategoryList',
            component: () => import('@/views/scenic/category/list'),
            meta: {
              title: '景点分类',
              icon: 'example'
            }
          },
          {
            path: 'add',
            name: 'scenicCategoryAdd',
            component: () => import('@/views/scenic/category/add'),
            meta: {
              title: '添加分类',
              icon: 'example'
            },
            hidden: true
          }
        ]
      }
    ]
  },
  {
    path: '/product',
    component: Layout,
    redirect: '/product/list',
    name: '商品管理',
    meta: {
      title: '商品管理',
      icon: 'example'
    },
    children: [
      {
        path: 'list',
        name: '商品列表',
        component: () => import('@/views/product/list'),
        meta: {
          title: '商品列表',
          icon: 'example'
        }
      },
      {
        path: 'add',
        name: '添加商品',
        component: () => import('@/views/product/add'),
        meta: {
          title: '添加商品',
          icon: 'example'
        }
      },
      {
        path: 'category',
        name: 'productCategory',
        component: () => import('@/views/product/category/index'),
        meta: {
          title: '分类管理',
          icon: 'example'
        },
        children: [
          {
            path: 'list',
            name: 'productCategoryList',
            component: () => import('@/views/product/category/list'),
            meta: {
              title: '商品分类',
              icon: 'example'
            }
          },
          {
            path: 'add',
            name: 'productCategoryAdd',
            component: () => import('@/views/product/category/add'),
            meta: {
              title: '添加分类',
              icon: 'example'
            },
            hidden: true
          }
        ]
      }
    ]
  },

  {
    path: '/example',
    component: Layout,
    redirect: '/example/table',
    name: 'Example',
    meta: {
      title: 'Example',
      icon: 'example',
      perms: ['example']
    },
    children: [
      {
        path: 'table',
        name: 'Table',
        component: () => import('@/views/example/table'),
        meta: {
          title: 'Table',
          icon: 'table',
          perms: ['example:table']
        }
      },
      {
        path: 'tree',
        name: 'Tree',
        component: () => import('@/views/example/tree'),
        meta: {
          title: 'Tree',
          icon: 'tree',
          perms: ['example:tree']
        }
      },
      {
        path: 'form',
        name: 'Form',
        component: () => import('@/views/example/form'),
        meta: {
          title: 'Form',
          icon: 'form',
          perms: ['form']
        }
      }
    ]
  },

  {
    path: '/sys',
    component: Layout,
    redirect: '/sys/admin',
    name: '系统管理',
    meta: {
      title: '系统管理',
      icon: 'system',
      perms: ['sys']
    },
    children: [
      {
        path: 'admin',
        name: '管理员',
        component: () => import('@/views/sys/admin'),
        meta: {
          title: '管理员',
          icon: 'admin',
          perms: ['sys:admin']
        }
      },
      {
        path: 'log',
        name: '后台日志',
        component: () => import('@/views/sys/log'),
        meta: {
          title: '后台日志',
          icon: 'log',
          perms: ['sys:log']
        }
      },
      {
        path: 'role',
        name: '角色管理',
        component: () => import('@/views/sys/role'),
        meta: {
          title: '角色管理',
          icon: 'role',
          perms: ['sys:role']
        }
      }
    ]
  },

  {
    path: '/menu',
    component: Layout,
    redirect: '/menu/menu1',
    name: '菜单',
    meta: {
      title: '菜单',
      icon: 'nested',
      perms: ['menu']
    },
    children: [
      {
        path: 'menu1',
        component: () => import('@/views/menu/menu1/index'), // Parent router-view
        name: 'Menu1',
        meta: {
          title: 'Menu1',
          icon: 'menu',
          perms: ['menu:menu1']
        },
        children: [
          {
            path: 'menu1-1',
            component: () => import('@/views/menu/menu1/menu1-1'),
            name: 'Menu1-1',
            meta: {
              title: 'Menu1-1',
              icon: 'menu',
              perms: ['menu:menu1:1']
            }
          },
          {
            path: 'menu1-2',
            component: () => import('@/views/menu/menu1/menu1-2'),
            name: 'Menu1-2',
            meta: {
              title: 'Menu1-2',
              icon: 'menu',
              perms: ['menu:menu1:2']
            },
            children: [
              {
                path: 'menu1-2-1',
                component: () => import('@/views/menu/menu1/menu1-2/menu1-2-1'),
                name: 'Menu1-2-1',
                meta: {
                  title: 'Menu1-2-1',
                  icon: 'menu',
                  perms: ['menu:menu1:2:1']
                }
              },
              {
                path: 'menu1-2-2',
                component: () => import('@/views/menu/menu1/menu1-2/menu1-2-2'),
                name: 'Menu1-2-2',
                meta: {
                  title: 'Menu1-2-2',
                  icon: 'menu',
                  perms: ['menu:menu1:2:2']
                }
              }
            ]
          },
          {
            path: 'menu1-3',
            component: () => import('@/views/menu/menu1/menu1-3'),
            name: 'Menu1-3',
            meta: {
              title: 'Menu1-3',
              icon: 'menu',
              perms: ['menu:menu1:3']
            }
          }
        ]
      },
      {
        path: 'menu2',
        component: () => import('@/views/menu/menu2/index'),
        meta: {
          title: 'menu2',
          icon: 'menu',
          perms: ['menu:menu2']
        }
      }
    ]
  },

  {
    path: 'external-link',
    component: Layout,
    children: [
      {
        path: 'https://github.com/w4o/sa',
        meta: { title: 'External Link', icon: 'link' }
      }
    ]
  },

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
