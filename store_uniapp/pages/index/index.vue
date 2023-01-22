<template>
	<view class="content">
		<view id="search">
			<!-- <form @submit="SearchById">
				<input type="text" name="id" placeholder="请输入要查询的id">
				<button confirm-type="search" form-type="submit" size="mini">查询ID</button>
			</form> -->
			<form @submit="Search">
				<input type="text" name="search" placeholder="请输入要查询的信息">
				<button confirm-type="search" form-type="submit" size="mini">模糊查询</button>
			</form>
		</view>
		<table border="1">
			<tr>
				<th>订单编号</th>
				<th>商品名</th>
				<th>客户名</th>
				<th>数量</th>
				<th>时间</th>
				<th>金额</th>
				<th>
					<navigator url="/pages/add_b/add" hover-class="other-navigator-hover">
						<button type="default" size="mini">添加</button>
					</navigator>
				</th>
			</tr>
			<tr v-for="bill in bills" :key="bill.id">
				<td>{{bill.id}}</td>
				<td>{{bill.name}}</td>
				<td>{{bill.cname}}</td>
				<td>{{bill.amountb}}</td>
				<td>{{bill.time}}</td>
				<td>{{bill.price}}</td>
				<td>
					<button v-on:click="deleteb(bill.id)" type="warn" size="mini">删除</button>
					<navigator :url="'/pages/update_b/update?bill='+ encodeURIComponent(JSON.stringify(bill))"
						hover-class="other-navigator-hover">
						<button type="primary" size="mini">修改</button>
					</navigator>
				</td>
			</tr>
		</table>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				bills: [],
			}
		},
		onLoad() {
			this.getList();
		},
		methods: {
			getList() {
				uni.request({
					url: 'http://localhost:8080/findAllBill',
					success: (res) => {
						this.bills = res.data.Data;
						console.log(this.bills)
					}
				});
			},
			//点击执行查询id
			// SearchById: function(e) {
			// 	uni.request({
			// 		url: 'http://localhost:8080/findBillById?id=' + e.detail.value.id,
			// 		success: (res) => {
			// 			this.bills = res.data.Data; //将查询到的数据输出到表格中
			// 			console.log(res.data.DataStatus);
			// 			console.log(e.detail.value.id); //获取的输入框中输入的id
			// 		}
			// 	});
			// },
			//点击查询
			Search: function(e) {
				uni.request({
					url: 'http://localhost:8080/findBill?search=' + e.detail.value.search,
					success: (res) => {
						this.bills = res.data.Data; //将查询到的数据输出到表格中
						console.log(res.data.DataStatus);
						if (res.data.DataStatus.statusCode == 100) {
							uni.showToast({
								title: '查询成功',
								icon: 'success'
							})
						} else {
							uni.showToast({
								title: '查询不到相关信息',
								icon: 'none'
							});
							this.getList();
						}
					}
				});
			},
			//点击删除
			deleteb: function(delid) {
				uni.request({
					url: 'http://localhost:8080/deleteBill?id=' + delid,
					success: (res) => {
						console.log(res.data);
						this.getList();
						this.tips()
					}
				});
			},
			//消息提示框
			tips() {
				uni.showToast({
					title: '删除成功',
					icon: 'success'
				})
			}


		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	input {
		display: inline-block;
	}

	#search {
		margin: 20px 0;
	}
</style>
