<template>
	<view class="content">
		<view id="search">
			<form @submit="Search">
				<input type="text" name="search" placeholder="请输入要查询的信息">
				<button confirm-type="search" form-type="submit" size="mini">模糊查询</button>
			</form>
		</view>
		<table border="1">
			<tr>
				<th>商品编号</th>
				<th>商品名</th>
				<th>数量</th>
				<th>单价</th>
				<th>总金额</th>
				<th>
					<navigator url="/pages/add_b/addp" hover-class="other-navigator-hover">
						<button type="default" size="mini">添加</button>
					</navigator>
				</th>
			</tr>
			<tr v-for="pl in pls" :key="pl.id">
				<td>{{pl.id}}</td>
				<td>{{pl.name}}</td>
				<td>{{pl.amount}}</td>
				<td>{{pl.priceIn}}</td>
				<td>{{pl.amountPrice}}</td>
				<td>
					<button v-on:click="deleteb(pl.id)" type="warn" size="mini">删除</button>
					<navigator :url="'/pages/update_b/updatep?pl='+ encodeURIComponent(JSON.stringify(pl))"
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
				pls: [],
				pl:{}

			}
		},
		onLoad() {
			this.getList();
		},
		methods: {
			getList() {
				uni.request({
					url: 'http://localhost:8080/findAllPL',
					success: (res) => {
						this.pls = res.data.Data;
						console.log(this.pls)
					}
				});
			},
			//点击查询
			Search: function(e) {
				uni.request({
					url: 'http://localhost:8080/findPLById?id=' + e.detail.value.search,
					success: (res) => {
						this.pl=res.data.Data
						this.pl.name=
						this.pl= res.data.Data; //将查询到的数据输出到表格中
						console.log(res.statusCode);//状态码
						console.log(res.data.DataStatus);//状态码
						console.log(res.data.Data.name);
						if(res.data.DataStatus.statusCode==100){
							uni.showToast({
								title: '查询成功',
								icon:'success'
							})
						}else{
							uni.showToast({
								title: '查询不到相关信息',	
								icon:'none'							
							});
							this.getList();
						}
					}
				});
			},
			
		},
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
