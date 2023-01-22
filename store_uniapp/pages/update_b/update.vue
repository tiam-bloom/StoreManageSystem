<template>
	<view>
		<form @submit="upb">
			<input v-model="id" type="text" name="id" disabled />
			<input v-model="name" type="text" name="name" placeholder="请输入商品名" focus="true" />
			<input v-model="cname" type="text" name="cname" placeholder="请输入客户姓名" />
			<input v-model="amountb" type="number" name="amountb" placeholder="请输入商品数量" />
			<input v-model="time" type="text" name="time" placeholder="请输入下单时间" />
			<input v-model="price" type="number" name="price" placeholder="请输入订单金额" />
			<button type="primary" form-type="submit">确定修改</button>
		</form>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad: function(option) {
			const bill = JSON.parse(decodeURIComponent(option.bill));
			console.log(bill); //获取的数据
			//填充数据
			this.id = bill.id;
			this.name = bill.name;
			this.cname = bill.cname;
			this.amountb = bill.amountb;
			this.time = bill.time;
			this.price = bill.price;
		},
		methods: {
			upb: function(e) {
				uni.request({
					url: 'http://localhost:8080/updateBill',
					method: 'POST',
					data: {
						id: e.detail.value.id,
						name: e.detail.value.name,
						cname: e.detail.value.cname,
						amountb: e.detail.value.amountb,
						time: e.detail.value.time,
						price: e.detail.value.price
					},
					success: (res) => {
						console.log(res.data); //返回成功的状态									
						console.log(e.detail.value); //获取到表单填入的数据						
						//返回页面
						uni.navigateBack({
							delta: 1
						});

					}
				})
			}

		}
	}
</script>

<style>
	input {
		margin: 20px 10px;

	}
</style>
